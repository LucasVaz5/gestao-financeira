package br.senac.go.resource;

import br.senac.go.interfaces.IResource;
import br.senac.go.model.Pessoa;
import br.senac.go.service.PessoaService;
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
@RequestMapping(path = "/api/pessoa")
@Tag(name = "pessoa", description = "documentação da classe pessoa")
public class PessoaResource implements IResource<Pessoa, Integer>
{
    @Autowired
    PessoaService pessoaService;

    @Override
    @Operation(
            summary = "Cria uma pessoa",
            description = "Método responsável para criar uma pessoa no sistema.",
            tags = { "pessoa" })
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = { @Content(schema = @Schema(implementation = Pessoa.class), mediaType = MediaType.APPLICATION_XML_VALUE) }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "304", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public Pessoa create(@Valid @RequestBody Pessoa entity)
    {
        log.info("Executado método PessoaResource.create");
        log.debug(String.format("Executando método PessoaResource.create | valores: %s",entity.toString()));

        Pessoa pessoa = pessoaService.create(entity);

        return pessoa;
    }

    @Override
    @Operation(
            summary = "Recupera uma pessoa",
            description = "Método responsável para recuperar uma pessoa no sistema.",
            tags = { "pessoa" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Pessoa.class), mediaType = MediaType.APPLICATION_XML_VALUE) }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @GetMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public Pessoa read(@Valid @RequestBody Pessoa entity) throws Exception
    {
        log.info("Executado método PessoaResource.read");
        log.debug(String.format("Executando método PessoaResource.read | valores: %s",entity.toString()));

        Pessoa pessoa = pessoaService.read(entity);

        return pessoa;
    }

    @Override
    @Operation(
            summary = "Recupera uma pessoa baseada no identificador",
            description = "Método responsável para recuperar uma pessoa no sistema baseado no identificador.",
            tags = { "pessoa" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Pessoa.class), mediaType = MediaType.APPLICATION_XML_VALUE) }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @GetMapping(value = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public Pessoa readById(@PathVariable("id")  Integer id) throws Exception
    {
        log.info("Executado método PessoaResource.readById");
        log.debug(String.format("Executando método PessoaResource.readById | valores: %d",id));

        Pessoa pessoa = pessoaService.readById(id);

        return pessoa;
    }

    @Override
    @Operation(
            summary = "Atualiza uma pessoa",
            description = "Método responsável para atualizar uma pessoa no sistema.",
            tags = { "pessoa" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Pessoa.class), mediaType = MediaType.APPLICATION_XML_VALUE) }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @PutMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public Pessoa update(@Valid @RequestBody Pessoa entity)
    {
        log.info("Executado método PessoaResource.update");
        log.debug(String.format("Executando método PessoaResource.update | valores: %s",entity.toString()));

        Pessoa pessoa = pessoaService.update(entity);

        return pessoa;
    }

    @Override
    @Operation(
            summary = "Atualiza parte dos dados de uma pessoa",
            description = "Método responsável para atualizar parte dos dados de uma pessoa no sistema.",
            tags = { "pessoa" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Pessoa.class), mediaType = MediaType.APPLICATION_XML_VALUE) }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @PatchMapping(value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public Pessoa updatePart(@PathVariable("id") Integer id, @Valid @RequestBody Pessoa entity) throws Exception
    {
        log.info("Executado método PessoaResource.updatePart");
        log.debug(String.format("Executando método PessoaResource.updatePart | valores: %d, %s",id,entity));

        Pessoa pessoa = pessoaService.updatePart(id, entity);

        return pessoa;
    }

    @Override
    @Operation(
            summary = "Atualiza todos os dados de uma pessoa",
            description = "Método responsável para atualizar todos os dados de uma pessoa no sistema.",
            tags = { "pessoa" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Pessoa.class), mediaType = MediaType.APPLICATION_XML_VALUE) }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @PutMapping("/{id}")
    public Pessoa updateFull(@PathVariable("id") Integer id, @Valid @RequestBody Pessoa entity)
    {
        log.info("Executado método PessoaResource.updateFull");
        log.debug(String.format("Executando método PessoaResource.updateFull | valores: %d, %s",id,entity));

        Pessoa pessoa = pessoaService.updateFull(id, entity);

        return pessoa;
    }

    @Override
    @Operation(
            summary = "Deleta uma pessoa com base no identificador",
            description = "Método responsável para deletar uma pessoa no sistema com base no identificador.",
            tags = { "pessoa" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Pessoa.class), mediaType = MediaType.APPLICATION_XML_VALUE) }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id)
    {
        log.info("Executado método PessoaResource.delete");
        log.debug(String.format("Executando método PessoaResource.delete | valores: %d",id));

        pessoaService.deleteById(id);
    }

    @Override
    @Operation(
            summary = "Deleta uma pessoa",
            description = "Método responsável para deletar uma pessoa no sistema.",
            tags = { "pessoa" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Pessoa.class), mediaType = MediaType.APPLICATION_XML_VALUE) }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @DeleteMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public void deleteByEntity(@Valid @RequestBody Pessoa entity)
    {
        log.info("Executado método PessoaResource.deleteByEntity");
        log.debug(String.format("Executando método PessoaResource.deleteByEntity | valores: %s",entity.toString()));

        pessoaService.delete(entity);
    }
}
