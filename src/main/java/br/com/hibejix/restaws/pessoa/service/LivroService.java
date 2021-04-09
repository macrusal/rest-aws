package br.com.hibejix.restaws.pessoa.service;

import br.com.hibejix.restaws.pessoa.exception.LivroNotFoundException;
import br.com.hibejix.restaws.pessoa.model.Livro;
import br.com.hibejix.restaws.pessoa.model.dto.LivroDTO;
import br.com.hibejix.restaws.pessoa.repository.LivroRepository;
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
public class LivroService {

    private static final Logger logger = LoggerFactory.getLogger( LivroService.class);

    private LivroRepository livroRepository;
    private ModelMapper modelMapper;

    public LivroService( LivroRepository livroRepository, ModelMapper modelMapper ) {
        this.livroRepository = livroRepository;
        this.modelMapper = modelMapper;
    }

    public LivroDTO create( LivroDTO dto) {
        logger.info( "Criando livro: {}", dto.toString() );
        var livro = modelMapper.map( dto, Livro.class );
        return modelMapper.map( livroRepository.save( livro ), LivroDTO.class );
    }

    public LivroDTO update(LivroDTO parametro) {

        var dto = findById( parametro.getId() );
        logger.info("Atualizando livro com o id: {}", parametro.getId());

        var entity = modelMapper.map(dto.builder()
                        .id( parametro.getId() )
                        .autor( parametro.getAutor() )
                        .titulo( parametro.getTitulo())
                        .dataLancamento( parametro.getDataLancamento() )
                        .preco( parametro.getPreco() )
                        .build(), Livro.class
        );

        return modelMapper.map( livroRepository.save( entity ), LivroDTO.class );
    }

    public void delete( ObjectId id ) {
        var dto = findById( id );
        logger.info("Excluindo livro com o id: {}", id);
        var livro = modelMapper.map( dto, Livro.class );
        livroRepository.deleteById( livro.getId() );
    }

    public LivroDTO findById( ObjectId id) {
        logger.info("Buscando livro com o id: {}", id);
        var livro = livroRepository.findById( id )
                .orElseThrow(() -> new LivroNotFoundException("LivroDTO com o id "+id+" não foi encontrada") );
        return modelMapper.map( livro, LivroDTO.class );
    }

    public List<LivroDTO> findAll() {
        var livros = livroRepository.findAll();
        logger.info("Retornnando {} livros do banco de dados", livros.stream().count());

        List<LivroDTO> dtos = modelMapper.map(livros, new TypeToken<List<LivroDTO>>() {}.getType());

        return dtos;
    }

}
