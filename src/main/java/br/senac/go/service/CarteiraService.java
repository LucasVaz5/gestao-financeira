package br.senac.go.service;

import br.senac.go.interfaces.IService;
import br.senac.go.model.Carteira;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CarteiraService implements IService<Carteira, Integer>
{

    @Override
    public Carteira create(Carteira entity)
    {
        log.info("Método CarteiraService.create executado");
        log.debug(String.format("Método CarteiraService.create executado com o objeto: %s", entity.toString()));

        return null;
    }

    @Override
    public Carteira readById(Integer id) throws Exception
    {
        log.info("Método CarteiraService.readById executado");
        log.debug(String.format("Método CarteiraService.readById executado com o objeto: %d", id));

        return null;
    }

    @Override
    public Carteira read(Carteira entity) throws Exception
    {
        log.info("Método CarteiraService.read executado");
        log.debug(String.format("Método CarteiraService.read executado com o objeto: %s", entity.toString()));

        return null;
    }

    @Override
    public Carteira update(Carteira entity)
    {
        log.info("Método CarteiraService.update executado");
        log.debug(String.format("Método CarteiraService.update executado com o objeto: %s", entity.toString()));

        return null;
    }

    @Override
    public Carteira updatePart(Integer id, Carteira entity) throws Exception
    {
        log.info("Método CarteiraService.updatePart executado");
        log.debug(String.format("Método CarteiraService.updatePart executado com o objeto: %d | %s", id, entity.toString()));

        return null;
    }

    @Override
    public Carteira updateFull(Integer id, Carteira entity)
    {
        log.info("Método CarteiraService.updateFull executado");
        log.debug(String.format("Método CarteiraService.updateFull executado com o objeto: %d | %s", id, entity.toString()));

        return null;
    }

    @Override
    public Carteira deleteById(Integer id)
    {
        log.info("Método CarteiraService.deleteById executado");
        log.debug(String.format("Método CarteiraService.deleteById executado com o objeto: %d", id));

        return null;
    }

    @Override
    public Carteira delete(Carteira entity)
    {
        log.info("Método CarteiraService.delete executado");
        log.debug(String.format("Método CarteiraService.delete executado com o objeto: %s", entity.toString()));

        return null;
    }
}
