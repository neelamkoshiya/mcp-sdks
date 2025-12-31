#!/usr/bin/env python3
import asyncio
from mcp.server.fastmcp import FastMCP

app = FastMCP("example-server")

@app.tool()
def echo(text: str = "") -> str:
    """Echo input text"""
    return f"Echo: {text}"

if __name__ == "__main__":
    app.run()
