package br.senac.go.resource;

import br.senac.go.interfaces.IResource;
import br.senac.go.model.Investimento;
import br.senac.go.service.InvestimentoService;
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
@RequestMapping(path = "/api/investimento")
@Tag(name = "investimento", description = "documentação ao resource investimento")
public class InvestimentoResource implements IResource<Investimento,Integer>
{
    @Autowired
    InvestimentoService investimentoService;

    @Override
    @Operation(
            summary = "Cria um investimento",
            description = "Método responsável para criar um investimento no sistema.",
            tags = { "investimento" })
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = { @Content(schema = @Schema(implementation = Investimento.class), mediaType = MediaType.APPLICATION_XML_VALUE) }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "304", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public Investimento create(@Valid @RequestBody Investimento entity)
    {
        log.info("Executado método InvestimentoResource.create");
        log.debug(String.format("Executando método InvestimentoResource.create | valores: %s",entity.toString()));

        Investimento investimento = investimentoService.create(entity);

        return investimento;
    }

    @Override
    @Operation(
            summary = "Recupera um investimento",
            description = "Método responsável para recuperar um investimento no sistema.",
            tags = { "investimento" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Investimento.class), mediaType = MediaType.APPLICATION_XML_VALUE) }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @GetMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public Investimento read(@Valid @RequestBody Investimento entity) throws Exception
    {
        log.info("Executado método InvestimentoResource.read");
        log.debug(String.format("Executando método InvestimentoResource.read | valores: %s",entity.toString()));

        Investimento investimento = investimentoService.read(entity);

        return investimento;
    }

    @Override
    @Operation(
            summary = "Recupera um investimento baseado no identificador",
            description = "Método responsável para recuperar um investimento no sistema baseado no identificador.",
            tags = { "investimento" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Investimento.class), mediaType = MediaType.APPLICATION_XML_VALUE) }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @GetMapping(value = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public Investimento readById(@PathVariable("id") Integer id) throws Exception
    {
        log.info("Executado método InvestimentoResource.readById");
        log.debug(String.format("Executando método InvestimentoResource.readById | valores: %d",id));

        Investimento investimento = investimentoService.readById(id);

        return investimento;
    }

    @Override
    @Operation(
            summary = "Atualiza um investimento",
            description = "Método responsável para atualizar um investimento no sistema.",
            tags = { "investimento" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Investimento.class), mediaType = MediaType.APPLICATION_XML_VALUE) }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @PutMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public Investimento update(@Valid @RequestBody Investimento entity)
    {
        log.info("Executado método InvestimentoResource.update");
        log.debug(String.format("Executando método InvestimentoResource.update | valores: %s",entity.toString()));

        Investimento investimento = investimentoService.update(entity);

        return investimento;
    }

    @Override
    @Operation(
            summary = "Atualiza parte dos dados de um investimento",
            description = "Método responsável para atualizar parte dos dados de um investimento no sistema.",
            tags = { "investimento" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Investimento.class), mediaType = MediaType.APPLICATION_XML_VALUE) }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @PatchMapping(value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public Investimento updatePart(@PathVariable("id") Integer id, @Valid @RequestBody Investimento entity) throws Exception
    {
        log.info("Executado método InvestimentoResource.updatePart");
        log.debug(String.format("Executando método InvestimentoResource.updatePart | valores: %d, %s",id,entity));

        Investimento investimento = investimentoService.updatePart(id, entity);

        return investimento;
    }

    @Override
    @Operation(
            summary = "Atualiza todos os dados de um investimento",
            description = "Método responsável para atualizar todos os dados de um investimento no sistema.",
            tags = { "investimento" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Investimento.class), mediaType = MediaType.APPLICATION_XML_VALUE) }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @PutMapping("/{id}")
    public Investimento updateFull(@PathVariable("id") Integer id, @Valid @RequestBody Investimento entity)
    {
        log.info("Executado método InvestimentoResource.updateFull");
        log.debug(String.format("Executando método InvestimentoResource.updateFull | valores: %d, %s",id,entity));

        Investimento investimento = investimentoService.updateFull(id, entity);

        return investimento;
    }

    @Override
    @Operation(
            summary = "Deleta um investimento com base no identificador",
            description = "Método responsável para deletar um investimento no sistema com base no identificador.",
            tags = { "investimento" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Investimento.class), mediaType = MediaType.APPLICATION_XML_VALUE) }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id)
    {
        log.info("Executado método InvestimentoResource.delete");
        log.debug(String.format("Executando método InvestimentoResource.delete | valores: %d",id));

        investimentoService.deleteById(id);
    }

    @Override
    @Operation(
            summary = "Deleta um investimento",
            description = "Método responsável para deletar um investimento no sistema.",
            tags = { "investimento" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Investimento.class), mediaType = MediaType.APPLICATION_XML_VALUE) }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @DeleteMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public void deleteByEntity(@Valid @RequestBody Investimento entity)
    {
        log.info("Executado método InvestimentoResource.deleteByEntity");
        log.debug(String.format("Executando método InvestimentoResource.deleteByEntity | valores: %s",entity.toString()));

        investimentoService.delete(entity);
    }
}
