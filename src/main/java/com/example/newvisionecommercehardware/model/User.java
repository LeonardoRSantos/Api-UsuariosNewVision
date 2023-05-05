package com.example.newvisionecommercehardware.model;

import com.example.newvisionecommercehardware.token.Token;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Data //Gera os getter e os setters
@Builder// prover uma maneira de criar objetos sem usar construtores e sem métodos setters
@NoArgsConstructor// Construtor sem argumentos
@AllArgsConstructor// Construtor com todos os campos da classe.
@Entity// A classe é uma entidade de banco de dados mapeando ela.
@Table(name = "_user")// Especifiquei o nome da tabela com essa anotação
public class User implements UserDetails { // implementei a classe UserDetails tornando compatível com o spring Security.

  @Id
  @GeneratedValue
  private Integer id;
  private String name;
  private String cpf;
  private Date dateBirth;
  private String telefone;

  @Column(unique = true) //email que já existe na tabela, uma exceção será lançada indicando que a restrição de unicidade foi violada.
  private String email;
  private String password;

  @Enumerated(EnumType.STRING)
  private Role role;

  @OneToMany(mappedBy = "user")
  private List<Token> tokens;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return List.of(new SimpleGrantedAuthority(role.name()));
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return email;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
