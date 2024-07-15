package com.aluracursos.screenmatch.service;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

public class ConsultaChatGPT {
    public static String obtenerTraduccion(String texto) {
        OpenAiService service = new OpenAiService("TU-API-KEY");

        CompletionRequest requisicion = CompletionRequest.builder()
                //Ver modelo actualizado
                .model("gpt-3.5-turbo-instruct")
                //Le manda al chat el prompt
                .prompt("traduce a español el siguiente texto: " + texto)
                //Caracteres de respuesta
                .maxTokens(1000)
                //Parámetro sinopsis más completa con más consultas
                .temperature(0.7)
                .build();

        var respuesta = service.createCompletion(requisicion);
        return respuesta.getChoices().get(0).getText();
    }
}
