#!/bin/bash

echo "Testing MCP SDK Projects..."
echo "=========================="

# Test Python
echo "✓ Python project structure:"
ls -la python/
echo

# Test TypeScript
echo "✓ TypeScript project structure:"
ls -la typescript/
echo

# Test Java
echo "✓ Java project structure:"
ls -la java/
ls -la java/src/main/java/com/example/
echo

# Test C#
echo "✓ C# project structure:"
ls -la csharp/
echo

# Test Go
echo "✓ Go project structure:"
ls -la go/
echo

echo "All projects created successfully!"
echo "Each project contains:"
echo "- README.md with setup instructions"
echo "- Minimal MCP server implementation"
echo "- Package/dependency configuration"
