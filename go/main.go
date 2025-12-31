package main

import (
	"context"
	"log"

	"github.com/modelcontextprotocol/go-sdk/mcp"
)

type Input struct {
	Text string `json:"text" jsonschema:"text to echo"`
}

type Output struct {
	Result string `json:"result" jsonschema:"echoed text"`
}

func Echo(ctx context.Context, req *mcp.CallToolRequest, input Input) (
	*mcp.CallToolResult,
	Output,
	error,
) {
	return nil, Output{Result: "Echo: " + input.Text}, nil
}

func main() {
	server := mcp.NewServer(&mcp.Implementation{Name: "example-server", Version: "1.0.0"}, nil)
	mcp.AddTool(server, &mcp.Tool{Name: "echo", Description: "Echo input text"}, Echo)
	
	if err := server.Run(context.Background(), &mcp.StdioTransport{}); err != nil {
		log.Fatal(err)
	}
}
