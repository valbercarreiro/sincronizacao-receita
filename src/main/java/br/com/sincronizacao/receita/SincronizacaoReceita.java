package br.com.sincronizacao.receita;

import java.io.File;
import java.util.List;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import br.com.sincronizacao.receita.processamento.EnviaReceita;
import br.com.sincronizacao.receita.processamento.ImportaArquivo;
import br.com.sincronizacao.receita.processamento.MontaArquivoRetorno;
import br.com.sincronizacao.receita.util.dto.ArquivoEnvioDTO;
import br.com.sincronizacao.receita.util.dto.ArquivoRespostaDTO;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class SincronizacaoReceita {

	public static void main(String[] args) throws Exception {
	     
	     log.info("Iniciando processamento...");
	     
	     File f = new File(args[0]);
	     if(args[0] == null || !f.exists()) {
	          throw new Exception("Caminho do arquivo inválido");
	     }
	     
	     ImportaArquivo importaArquivo = new ImportaArquivo();
	     List<ArquivoEnvioDTO> arquivoEnvio = importaArquivo.lerArquivo(args[0]);
	     EnviaReceita enviaReceita = new EnviaReceita();
	     List<ArquivoRespostaDTO> arquivoRetorno = enviaReceita.enviaDadosReceita(arquivoEnvio);
	     MontaArquivoRetorno montaRetorno = new MontaArquivoRetorno();
	     montaRetorno.enviaDadosReceita(arquivoRetorno);
	     
	     log.info("Processamento finalizado...");
	}

}
