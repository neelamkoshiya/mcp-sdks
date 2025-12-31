package com.example;

import io.modelcontextprotocol.sdk.McpServer;
import io.modelcontextprotocol.sdk.McpServerFeatures;
import io.modelcontextprotocol.sdk.schema.McpSchema;
import io.modelcontextprotocol.sdk.server.stdio.StdioServerTransportProvider;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;

public class ExampleServer {
    public static void main(String[] args) {
        var transportProvider = new StdioServerTransportProvider(new ObjectMapper());
        
        var server = McpServer.sync(transportProvider)
            .serverInfo("example-server", "1.0.0")
            .capabilities(McpSchema.ServerCapabilities.builder()
                .tools(true)
                .build())
            .build();

        var echoTool = new McpServerFeatures.SyncToolSpecification(
            new McpSchema.Tool("echo", "Echo input text", "{}"),
            (exchange, arguments) -> {
                String text = (String) arguments.getOrDefault("text", "");
                return new McpSchema.CallToolResult("Echo: " + text, false);
            }
        );

        server.addTool(echoTool);
        
        // Keep server running
        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
