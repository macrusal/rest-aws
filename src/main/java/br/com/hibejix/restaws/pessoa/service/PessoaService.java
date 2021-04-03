package br.com.hibejix.restaws.pessoa.service;

import br.com.hibejix.restaws.pessoa.exception.PessoaNotFoundException;
import br.com.hibejix.restaws.pessoa.model.Pessoa;
import br.com.hibejix.restaws.pessoa.model.dto.PessoaDTO;
import br.com.hibejix.restaws.pessoa.repository.PessoaRepository;
import org.bson.types.ObjectId;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author macrusal on 02/04/21
 * @project rest-aws
 */
@Service
public class PessoaService {

    private static final Logger logger = LoggerFactory.getLogger(PessoaService.class);

    private PessoaRepository pessoaRepository;
    private ModelMapper modelMapper;

    public PessoaService( PessoaRepository pessoaRepository, ModelMapper modelMapper ) {
        this.pessoaRepository = pessoaRepository;
        this.modelMapper = modelMapper;
    }

    public PessoaDTO create( PessoaDTO dto) {
        logger.info( "Criando pessoa: {}", dto.toString() );
        var pessoa = modelMapper.map( dto, Pessoa.class );
        return modelMapper.map( pessoaRepository.save( pessoa ), PessoaDTO.class );
    }

    public PessoaDTO update(PessoaDTO parametro) {

        var dto = findById( parametro.getId() );
        logger.info("Atualizando pessoa com o id: {}", parametro.getId());

        var entity = modelMapper.map(dto.builder()
                        .id( parametro.getId() )
                        .primeiroNome( parametro.getPrimeiroNome() )
                        .ultimoNome( parametro.getUltimoNome() )
                        .sexo( parametro.getSexo() )
                        .endereco( parametro.getEndereco() )
                        .build(), Pessoa.class
        );

        return modelMapper.map( pessoaRepository.save( entity ), PessoaDTO.class );
    }

    public void delete( ObjectId id ) {
        var dto = findById( id );
        logger.info("Excluindo pessoa com o id: {}", id);
        var pessoa = modelMapper.map( dto, Pessoa.class );
        pessoaRepository.deleteById( pessoa.getId() );
    }

    public PessoaDTO findById( ObjectId id) {
        logger.info("Buscando pessoa com o id: {}", id);
        var pessoa = pessoaRepository.findById( id )
                .orElseThrow(() -> new PessoaNotFoundException("PessoaDTO com o id "+id+" não foi encontrada") );
        return modelMapper.map( pessoa, PessoaDTO.class );
    }

    public List<PessoaDTO> findAll() {
        var pessoas = pessoaRepository.findAll();
        logger.info("Retornnando {} pessoas do banco de dados", pessoas.stream().count());

        List<PessoaDTO> dtos = modelMapper.map(pessoas, new TypeToken<List<PessoaDTO>>() {}.getType());

        return dtos;
    }

}
