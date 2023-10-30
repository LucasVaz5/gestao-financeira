package br.senac.go.resource;

import br.senac.go.interfaces.IResource;
import br.senac.go.model.Carteira;
import br.senac.go.service.CarteiraService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(path = "/api/carteira")
@Tag(name = "carteira", description = "documentação ao resource carteira")
public class CarteiraResource  implements IResource<Carteira, Integer>
{
    @Autowired
    CarteiraService carteiraService;

    @Override
    @Operation(
            summary = "Cria uma carteira",
            description = "Método responsável para criar uma carteira no sistema.",
            tags = { "carteira" })
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = { @Content(schema = @Schema(implementation = Carteira.class), mediaType = MediaType.APPLICATION_XML_VALUE) }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "304", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public Carteira create(@Valid @RequestBody Carteira entity)
    {
        log.info("Executado método CarteiraResource.create");
        log.debug(String.format("Executando método CarteiraResource.create | valores: %s",entity.toString()));

        Carteira carteira = carteiraService.create(entity);

        return carteira;
    }

    @Override
    @Operation(
            summary = "Recupera uma carteira",
            description = "Método responsável para recuperar uma carteira no sistema.",
            tags = { "carteira" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Carteira.class), mediaType = MediaType.APPLICATION_XML_VALUE) }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @GetMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public Carteira read(@Valid @RequestBody Carteira entity) throws Exception
    {
        log.info("Executado método CarteiraResource.read");
        log.debug(String.format("Executando método CarteiraResource.read | valores: %s",entity.toString()));

        Carteira carteira = carteiraService.read(entity);

        return carteira;
    }

    @Override
    @Operation(
            summary = "Recupera uma carteira baseada no identificador",
            description = "Método responsável para recuperar uma carteira no sistema baseado no identificador.",
            tags = { "carteira" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Carteira.class), mediaType = MediaType.APPLICATION_XML_VALUE) }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @GetMapping(value = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public Carteira readById(@PathVariable("id") Integer id) throws Exception
    {
        log.info("Executado método CarteiraResource.readById");
        log.debug(String.format("Executando método CarteiraResource.readById | valores: %d",id));

        Carteira carteira = carteiraService.readById(id);

        return carteira;
    }

    @Override
    @Operation(
            summary = "Atualiza uma carteira",
            description = "Método responsável para atualizar uma carteira no sistema.",
            tags = { "carteira" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Carteira.class), mediaType = MediaType.APPLICATION_XML_VALUE) }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @PutMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public Carteira update(@Valid @RequestBody Carteira entity)
    {
        log.info("Executado método CarteiraResource.update");
        log.debug(String.format("Executando método CarteiraResource.update | valores: %s",entity.toString()));

        Carteira carteira = carteiraService.update(entity);

        return carteira;
    }

    @Override
    @Operation(
            summary = "Atualiza parte dos dados de uma carteira",
            description = "Método responsável para atualizar parte dos dados de uma carteira no sistema.",
            tags = { "carteira" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Carteira.class), mediaType = MediaType.APPLICATION_XML_VALUE) }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @PatchMapping(value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public Carteira updatePart(@PathVariable("id") Integer id, @Valid @RequestBody Carteira entity) throws Exception
    {
        log.info("Executado método CarteiraResource.updatePart");
        log.debug(String.format("Executando método CarteiraResource.updatePart | valores: %d, %s",id,entity));

        Carteira carteira = carteiraService.updatePart(id, entity);

        return carteira;
    }

    @Override
    @Operation(
            summary = "Atualiza todos os dados de uma carteira",
            description = "Método responsável para atualizar todos os dados de uma carteira no sistema.",
            tags = { "carteira" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Carteira.class), mediaType = MediaType.APPLICATION_XML_VALUE) }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @PutMapping("/{id}")
    public Carteira updateFull(@PathVariable("id") Integer id, @Valid @RequestBody Carteira entity)
    {
        log.info("Executado método CarteiraResource.updateFull");
        log.debug(String.format("Executando método CarteiraResource.updateFull | valores: %d, %s",id,entity));

        Carteira carteira = carteiraService.updateFull(id, entity);

        return carteira;
    }

    @Override
    @Operation(
            summary = "Deleta uma carteira com base no identificador",
            description = "Método responsável para deletar uma carteira no sistema com base no identificador.",
            tags = { "carteira" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Carteira.class), mediaType = MediaType.APPLICATION_XML_VALUE) }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id)
    {
        log.info("Executado método CarteiraResource.delete");
        log.debug(String.format("Executando método CarteiraResource.delete | valores: %d",id));

        carteiraService.deleteById(id);
    }

    @Override
    @Operation(
            summary = "Deleta uma carteira",
            description = "Método responsável para deletar uma carteira no sistema.",
            tags = { "carteira" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Carteira.class), mediaType = MediaType.APPLICATION_XML_VALUE) }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @DeleteMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public void deleteByEntity(@Valid @RequestBody Carteira entity)
    {
        log.info("Executado método CarteiraResource.deleteByEntity");
        log.debug(String.format("Executando método CarteiraResource.deleteByEntity | valores: %s",entity.toString()));

        carteiraService.delete(entity);
    }
}
