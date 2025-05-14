FROM debian:bookworm-slim

WORKDIR /app

# Copy everything (binary + config etc.)
COPY target/native .

# Make sure binary is executable
RUN chmod +x /app/kotlin-demo

ENTRYPOINT ["/app/kotlin-demo"]