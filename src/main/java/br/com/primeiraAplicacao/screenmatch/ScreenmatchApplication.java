package br.com.primeiraAplicacao.screenmatch;

import br.com.primeiraAplicacao.screenmatch.model.DadosEpisodios;
import br.com.primeiraAplicacao.screenmatch.model.DadosSerie;
import br.com.primeiraAplicacao.screenmatch.service.ConsumoApi;
import br.com.primeiraAplicacao.screenmatch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ConsumoApi consumoApi = new ConsumoApi();
		var json = consumoApi.obterDados("http://www.omdbapi.com/?t=the+rookie&apikey=c61f9e1c");
		System.out.println(json);
		ConverteDados conversor = new ConverteDados();
		var dadosSerie = conversor.obterDados(json, DadosSerie.class);
		System.out.println(dadosSerie);
		json = consumoApi.obterDados("http://www.omdbapi.com/?t=the+rookie&Season=1&Episode=2&apikey=c61f9e1c");
		DadosEpisodios dadosEpisodios = conversor.obterDados(json,DadosEpisodios.class);
		System.out.println(dadosEpisodios);
	}
}
