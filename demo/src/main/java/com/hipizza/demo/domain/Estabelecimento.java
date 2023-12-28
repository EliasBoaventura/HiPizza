package com.hipizza.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Estabelecimento")
@Data
public class Estabelecimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", length = 80)
    @NotBlank(message = "nome não pode ficar em branco!")
    @Size(min = 0, max = 80, message = "Nome inválido!(Deve conter no máximo 80 caracteres)")
    private String nome;

    @Column(name = "cpf", length = 11, unique = true)
    @NotBlank(message = "CPF não pode ficar em branco!")
    @Size(min = 11, max = 11, message = "CPF inválido!(Deve conter 11 dígitos)")
    @Pattern(regexp = "\\d*", message = "CPF deve conter apenas números")
    private String cpf;

    @Column(name = "email")
    private String email; // Provisório até fazer a parte de autenticação

    @Column(name = "telefone", length = 20)
    @NotBlank(message = "Telefone não pode ficar em branco!")
    @Size(min = 5, max = 20, message = "Telefone inválido!(Deve conter no máximo 20 dígitos)")
    @Pattern(regexp = "\\d*", message = "Telefone deve conter apenas números")
    private String telefone;

    @Column(name = "endereco", length = 150)
    @NotBlank(message = "Endereço não pode ficar em branco!")
    @Size(min = 2, max = 150, message = "Endereço inválido!(Deve conter no máximo 150 dígitos)")
    private String endereco;

    @Column(name = "cnpj", length = 14, unique = true)
    @NotBlank(message = "CNPJ não pode ficar em branco!")
    @Size(min = 14, max = 14, message = "CNPJ inválido!(Deve conter 14 dígitos)")
    @Pattern(regexp = "\\d*", message = "CNPJ deve conter apenas números")
    private String cnpj;

    @Column(name = "razao_social", length = 80)
    @NotBlank(message = "Razão Social não pode ficar em branco!")
    @Size(min = 14, max = 14, message = "Razão Social inválido!(Deve conter no máximo 80 caracteres)")
    private String razao_social;

    @Column(name = "agencia", length = 4)
    @NotBlank(message = "Agência não pode ficar em branco!")
    @Size(min = 4, max = 4, message = "Agência inválida!(Deve conter 4 dígitos)")
    @Pattern(regexp = "\\d*", message = "Agência deve conter apenas números")
    private String agencia;

    @Column(name = "conta_corrente", length = 20)
    @NotBlank(message = "Conta Corrente não pode ficar em branco!")
    @Size(min = 1, max = 20, message = "Conta Corrente inválida!(Deve conter no máximo 20 dígitos)")
    @Pattern(regexp = "\\d*", message = "Conta Corrente deve conter apenas números")
    private String conta_corrente;

    @Column(name = "senha")
    private String senha; // Provisório até fazer a parte de autenticação

    @OneToMany(mappedBy = "estabelecimento", cascade = CascadeType.ALL)
    @JsonManagedReference
    @JsonIgnore
    private List<Funcionario> funcionarios = new ArrayList<>();

    @OneToMany(mappedBy = "estabelecimento", cascade = CascadeType.ALL)
    @JsonManagedReference
    @JsonIgnore
    private List<Categoria> categorias = new ArrayList<>();

    @OneToMany(mappedBy = "estabelecimento", cascade = CascadeType.ALL)
    @JsonManagedReference
    @JsonIgnore
    private List<Pedido> pedidos = new ArrayList<>();
}
