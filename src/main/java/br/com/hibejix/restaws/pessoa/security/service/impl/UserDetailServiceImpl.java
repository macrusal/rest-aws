package br.com.hibejix.restaws.pessoa.security.service.impl;

import br.com.hibejix.restaws.pessoa.model.Pessoa;
import br.com.hibejix.restaws.pessoa.repository.PessoaRepository;
import br.com.hibejix.restaws.pessoa.security.UserSpringSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author macrusal on 11/04/21
 * @project rest-aws
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    PessoaRepository pessoaRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Pessoa pessoa = pessoaRepository.findByEmail(email);
        if (pessoa == null) {
            throw new UsernameNotFoundException(email);
        }
        return new UserSpringSecurity(pessoa.getId(), pessoa.getEmail(), pessoa.getSenha(), pessoa.getPerfis());
    }
}
