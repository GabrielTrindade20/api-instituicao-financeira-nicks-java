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
@Table(name = "TableCustomer")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class CustomerEntity implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCustomer")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "phone")
    private String telephone;

    @Column(name = "password")
    private String password;

    @ManyToMany
    @JoinTable(
            name = "TableCustomer_has_TableAddress",
            joinColumns = @JoinColumn(name = "Fk_customer_idCustomer"),
            inverseJoinColumns = @JoinColumn(name = "Fk_address_idAddress")
    )
    private List<AddressEntity> address;

    @OneToMany(mappedBy = "customer")
    private List<AccountEntity> customer;
}
