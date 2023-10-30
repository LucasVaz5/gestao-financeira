package br.senac.go.service;

import br.senac.go.interfaces.IService;
import br.senac.go.model.Pessoa;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PessoaService implements IService<Pessoa, Integer>
{

    @Override
    public Pessoa create(Pessoa entity)
    {
        log.info("Método PessoaService.create executado");
        log.debug(String.format("Método PessoaService.create executado com o objeto: %s", entity.toString()));

        return null;
    }

    @Override
    public Pessoa readById(Integer id) throws Exception
    {
        log.info("Método PessoaService.readById executado");
        log.debug(String.format("Método PessoaService.readById executado com o objeto: %d", id));

        return null;
    }

    @Override
    public Pessoa read(Pessoa entity) throws Exception
    {
        log.info("Método PessoaService.read executado");
        log.debug(String.format("Método PessoaService.read executado com o objeto: %s", entity.toString()));

        return null;
    }

    @Override
    public Pessoa update(Pessoa entity)
    {
        log.info("Método PessoaService.update executado");
        log.debug(String.format("Método PessoaService.update executado com o objeto: %s", entity.toString()));

        return null;
    }

    @Override
    public Pessoa updatePart(Integer id, Pessoa entity) throws Exception
    {
        log.info("Método PessoaService.updatePart executado");
        log.debug(String.format("Método PessoaService.updatePart executado com o objeto: %d | %s", id, entity.toString()));

        return null;
    }

    @Override
    public Pessoa updateFull(Integer id, Pessoa entity)
    {
        log.info("Método PessoaService.updateFull executado");
        log.debug(String.format("Método PessoaService.updateFull executado com o objeto: %d | %s", id, entity.toString()));

        return null;
    }

    @Override
    public Pessoa deleteById(Integer id)
    {
        log.info("Método PessoaService.deleteById executado");
        log.debug(String.format("Método PessoaService.deleteById executado com o objeto: %d", id));

        return null;
    }

    @Override
    public Pessoa delete(Pessoa entity)
    {
        log.info("Método PessoaService.delete executado");
        log.debug(String.format("Método PessoaService.delete executado com o objeto: %s", entity.toString()));

        return null;
    }
}
