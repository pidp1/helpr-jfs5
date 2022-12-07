package org.soulcodeacademy.helpr.services;

import org.soulcodeacademy.helpr.domain.Cargo;
import org.soulcodeacademy.helpr.domain.Chamado;
import org.soulcodeacademy.helpr.domain.Cliente;
import org.soulcodeacademy.helpr.domain.Funcionario;
import org.soulcodeacademy.helpr.domain.enums.Perfil;
import org.soulcodeacademy.helpr.domain.enums.StatusChamado;
import org.soulcodeacademy.helpr.repositories.CargoRepository;
import org.soulcodeacademy.helpr.repositories.ChamadoRepository;
import org.soulcodeacademy.helpr.repositories.ClienteRepository;
import org.soulcodeacademy.helpr.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PopulateService {
    @Autowired
    private CargoRepository cargoRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ChamadoRepository chamadoRepository;

    @Autowired
    private PasswordEncoder encoder;

    public void populate() {
        Cargo c1 = new Cargo(null, "Diretor Geral", "Gerencia a empresa", 30000.0);
        Cargo c2 = new Cargo(null, "Diretor de Setor", "Gerencia um setor da empresa", 18000.0);
        Cargo c3 = new Cargo(null, "Técnico geral", "Resolve os chamados urgentes", 12000.0);

        Funcionario f1 = new Funcionario(null, "Renato Pereira", "renato.pereira@gmail.com", "68258098144", encoder.encode("12345"), null, c1);
        f1.setPerfil(Perfil.ADMIN);
        Funcionario f2 = new Funcionario(null, "Victor Icoma", "victor.icoma@gmail.com", "51127383671", encoder.encode("12345"), null, c2);
        Funcionario f3 = new Funcionario(null, "Pedro Imparato", "pedro.imparato@gmail.com", "458516823589", encoder.encode("12345"), null, c3);
        f3.setPerfil(Perfil.ADMIN);
        Funcionario f4 = new Funcionario(null, "Alberto Roberto", "alberto.robs@gmail.com", "64643539032", encoder.encode("12345"), null, c1);
        f4.setPerfil(Perfil.ADMIN);
        Funcionario f6 = new Funcionario(null, "Seu Peru", "echarpeglamurosa@gmail.com", "386324932561", encoder.encode("12345"), null, c2);
        f6.setPerfil(Perfil.ADMIN);
        Funcionario f7 = new Funcionario(null, "Seya de Pégasus", "seyameteoro@gmail.com", "66836869040", encoder.encode("12345"), null, c1);
        f7.setPerfil(Perfil.ADMIN);
        Funcionario f8 = new Funcionario(null, "Ikki de Fênix", "fenixbraba@gmail.com", "29083103099", encoder.encode("12345"), null, c2);
        f8.setPerfil(Perfil.ADMIN);
        Funcionario f9 = new Funcionario(null, "Shyriu de Dragão", "semolho@gmail.com", "51127383671", encoder.encode("12345"), null, c1);
        f9.setPerfil(Perfil.FUNCIONARIO);
        Funcionario f10 = new Funcionario(null, "Shun de Andrômeda", "correntedapaz@gmail.com", "51127383671", encoder.encode("12345"), null, c1);
        f10.setPerfil(Perfil.FUNCIONARIO);
        Funcionario f11 = new Funcionario(null, "Saori Atena", "morrimaspassobem@gmail.com", "51127383671", encoder.encode("12345"), null, c3);
        f11.setPerfil(Perfil.FUNCIONARIO);


        Cliente cl1 = new Cliente(null, "José Almir", "jose.almir@gmail.com", "12659185115", encoder.encode("batata"), "9999999999");
        Cliente cl2 = new Cliente(null, "Pedro João", "pedro@gmail.com", "37734168302", encoder.encode("batata"), "9999999997");
        Cliente cl3 = new Cliente(null, "Vegeta", "vegetaboladao@gmail.com", "31756496021", encoder.encode("batata"), "9999999997");
        Cliente cl4 = new Cliente(null, "Kuririn", "morridenovo@gmail.com", "25907661062", encoder.encode("batata"), "9999999997");


        Chamado ch1 = new Chamado(null, "Primeiro chamado do sistema", "Revisar as entidades criadas");
        ch1.setCliente(cl1);
        Chamado ch2 = new Chamado(null, "Ativar VPN do sistema", "Conectar aos servidores remotos");
        ch2.setCliente(cl2);
        ch2.setFuncionario(f1);
        ch2.setStatus(StatusChamado.ATRIBUIDO);
        Chamado ch3 = new Chamado(null, "Fazer atualização de firmware", "atualizar remotamente o firmware das máquinas");
        ch3.setStatus(StatusChamado.RECEBIDO);
        Chamado ch4 = new Chamado(null, "Fazer correção de bugs", "Corrigir bugs na página de contato");
        ch4.setStatus(StatusChamado.RECEBIDO);
        Chamado ch5 = new Chamado(null, "instalar wordpress no servidor", "Instalar software no servidor do cliente");
        ch5.setStatus(StatusChamado.RECEBIDO);
        Chamado ch6 = new Chamado(null, "Correção de erros na página 'Frieza Fede'", "fazer revisão de erros ná página principal do site");
        ch6.setStatus(StatusChamado.CONCLUIDO);
        Chamado ch7 = new Chamado(null, "enviar atualizações para o site", "enviar atualizações");
        ch7.setStatus(StatusChamado.CONCLUIDO);

        this.cargoRepository.saveAll(List.of(c1, c2, c3));
        this.funcionarioRepository.saveAll(List.of(f1, f2, f3, f4, f6, f7, f8, f9, f10, f11));
        this.clienteRepository.saveAll(List.of(cl1, cl2, cl3, cl4));
        this.chamadoRepository.saveAll(List.of(ch1, ch2, ch3, ch4, ch5, ch6, ch7));
    }
}

