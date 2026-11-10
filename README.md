# toy-redis

A toy Redis clone in pure Java, written by hand to learn, as part of my [Java roadmap](https://tjanvier.org/posts/java-learning-roadmap).

No frameworks, no AI-written code. The real `redis-server` is the spec.

1. **RESP2 protocol**: incremental parser and serializer, partial-frame tests.
2. **TCP server**: thread per client, thread-safe store, `PING` `ECHO` `SET` `GET` `DEL` `EXISTS` `INCR` `DECR`.
3. **AOF persistence**: append-only log, replay on startup, crash recovery.
4. **Async client**: `CompletableFuture` API, pipelining, timeouts.

## Possible extensions

Hashes, lists, expiry, RESP3, NIO event loop.

## References

- [RESP specification](https://redis.io/docs/latest/develop/reference/protocol-spec/)
- [Redis commands](https://redis.io/docs/latest/commands/)
