package com.projetoNicks.server.Entities;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode.Include;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TableCliente")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class ClienteEntity implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCliente")
    private Long idCliente;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "senha")
    private String senha;

    @ManyToMany
    @JoinTable(
            name = "TableCliente_tem_TableEndereco",
            joinColumns = @JoinColumn(name = "Fk_cliente_idCliente"),
            inverseJoinColumns = @JoinColumn(name = "Fk_endereco_idEndereco")
    )
    private List<EnderecoEntity> enderecos;

    @OneToMany(mappedBy = "cliente")
    private List<ContaEntity> contas;
}
