<p align="center">
  <img id="Infinitum Framework" src="http://infinitumframework.com/images/logo.png" />
</p>

Infinitum Web
-------------

Infinitum Web offers a REST client that provides support for caching, simplified authentication, and a number of other features that allow developers to consume REST APIs with ease. The framework offers both fine- and coarse- grained clients, meaning developers can choose to deal with HTTP responses at a low level (i.e. manually performing message interpretation, deserialization, etc.) or a high level (i.e. allowing the framework to handle message conversion).

Web Features
------------

* Fine-grained REST client: low-level client for dealing directly with HTTP responses
* Coarse-grained REST client: high-level client for retrieving HTTP responses as objects
* Fully extensible: REST client can be easily extended or re-implemented for specific business needs
* Flexible: register JSON or XML deserializers or implement your own message converter
* Caching: HTTP/1.1-compliant caching in REST clients
* Authentication support: enable token-based/shared-secret web service authentication or implement your own authentication strategy
* Token generation: provides support for custom token generation for situations where a changing, per-user, or per-session shared secret is desirable
