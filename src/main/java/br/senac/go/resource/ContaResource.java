package br.senac.go.resource;

import br.senac.go.interfaces.IResource;
import br.senac.go.model.Conta;
import br.senac.go.service.ContaService;
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
@RequestMapping(path = "/api/conta")
@Tag(name = "conta", description = "documentação ao resource conta")
/*@Tags({
        @Tag(name = "conta", description = "documentação ao resource conta"),
        @Tag(name = "investimento", description = "documentação para conta de investimento")
})*/
public class ContaResource implements IResource<Conta, Integer>
{
    @Autowired
    ContaService contaService;

    //////////  POST

    @Override
    @Operation(
            summary = "Cria uma conta",
            description = "Método responsável para criar uma conta no sistema.",
            tags = { "conta" })
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = { @Content(schema = @Schema(implementation = Conta.class), mediaType = MediaType.APPLICATION_XML_VALUE) }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "304", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public Conta create(@Valid @RequestBody Conta entity)
    {
        log.info("Executado método ContaResource.create");
        log.debug(String.format("Executando método ContaResource.create | valores: %s",entity.toString()));

        Conta Conta = contaService.create(entity);

        return Conta;
    }

    //////////  GET

    @Override
    @Operation(
            summary = "Recupera uma conta",
            description = "Método responsável para recuperar uma conta no sistema.",
            tags = { "conta" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Conta.class), mediaType = MediaType.APPLICATION_XML_VALUE) }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @GetMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public Conta read(@Valid @RequestBody Conta entity) throws Exception {
        log.info("Executado método ContaResource.read");
        log.debug(String.format("Executando método ContaResource.read | valores: %s",entity.toString()));

        Conta conta = contaService.read(entity);

        return conta;
    }

    @Override
    @Operation(
            summary = "Recupera uma conta baseada no identificador",
            description = "Método responsável para recuperar uma conta no sistema baseado no identificador.",
            tags = { "conta" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Conta.class), mediaType = MediaType.APPLICATION_XML_VALUE) }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @GetMapping(value = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public Conta readById(@PathVariable("id") Integer id) throws Exception {
        log.info("Executado método ContaResource.readById");
        log.debug(String.format("Executando método ContaResource.readById | valores: %d",id));

        Conta conta = contaService.readById(id);

        return conta;
    }

    //////////  PUT - PATCH

    @Override
    @Operation(
            summary = "Atualiza parte dos dados de uma conta",
            description = "Método responsável para atualizar parte dos dados de uma conta no sistema.",
            tags = { "conta" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Conta.class), mediaType = MediaType.APPLICATION_XML_VALUE) }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @PatchMapping(value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public Conta updatePart(@PathVariable("id") Integer id, @Valid @RequestBody Conta entity) throws Exception {
        log.info("Executado método ContaResource.updatePart");
        log.debug(String.format("Executando método ContaResource.updatePart | valores: %d, %s",id,entity));

        Conta conta = contaService.updatePart(id, entity);

        return conta;
    }

    @Override
    @Operation(
            summary = "Atualiza todos os dados de uma conta",
            description = "Método responsável para atualizar todos os dados de uma conta no sistema.",
            tags = { "conta" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Conta.class), mediaType = MediaType.APPLICATION_XML_VALUE) }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @PutMapping("/{id}")
    public Conta updateFull(@PathVariable("id") Integer id, @Valid @RequestBody Conta entity)
    {
        log.info("Executado método ContaResource.updateFull");
        log.debug(String.format("Executando método ContaResource.updateFull | valores: %d, %s",id,entity));

        Conta conta = contaService.updateFull(id, entity);

        return conta;
    }

    @Override
    @Operation(
            summary = "Atualiza uma conta",
            description = "Método responsável para atualizar uma conta no sistema.",
            tags = { "conta" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Conta.class), mediaType = MediaType.APPLICATION_XML_VALUE) }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @PutMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public Conta update(@Valid @RequestBody Conta entity)
    {
        log.info("Executado método ContaResource.update");
        log.debug(String.format("Executando método ContaResource.update | valores: %s",entity.toString()));

        Conta conta = contaService.update(entity);

        return conta;
    }

    //////////  DELETE

    @Override
    @Operation(
            summary = "Deleta uma conta com base no identificador",
            description = "Método responsável para deletar uma conta no sistema com base no identificador.",
            tags = { "conta" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Conta.class), mediaType = MediaType.APPLICATION_XML_VALUE) }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id)
    {
        log.info("Executado método ContaResource.delete");
        log.debug(String.format("Executando método ContaResource.delete | valores: %d",id));

        contaService.deleteById(id);
    }

    @Override
    @Operation(
            summary = "Deleta uma conta",
            description = "Método responsável para deletar uma conta no sistema.",
            tags = { "conta" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Conta.class), mediaType = MediaType.APPLICATION_XML_VALUE) }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @DeleteMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public void deleteByEntity(@Valid @RequestBody Conta entity)
    {
        log.info("Executado método ContaResource.deleteByEntity");
        log.debug(String.format("Executando método ContaResource.deleteByEntity | valores: %s",entity.toString()));

        contaService.delete(entity);
    }
}
