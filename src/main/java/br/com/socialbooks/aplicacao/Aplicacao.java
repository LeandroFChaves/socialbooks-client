package br.com.socialbooks.aplicacao;

import java.net.URI;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import br.com.socialbooks.domain.Livro;

public class Aplicacao {

	public static void main(String[] args) {
		RestTemplate restTemplate = new RestTemplate();

		// Basic cmVzdDpyZXN0 -> Usuário e senha rest em base64.
		RequestEntity<Void> request = RequestEntity.get(URI.create("http://localhost:8080/livros"))
				.header("Authorization", "Basic cmVzdDpyZXN0").build();
		
		ResponseEntity<Livro[]> response = restTemplate.exchange(request, Livro[].class);
		
		for (Livro livro : response.getBody()){
			System.out.println("Livro: " + livro.getNome());
		}
	}
}