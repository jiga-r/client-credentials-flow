# OAUTH - OKTA

## Authentication
- Authentication is done by OKTA

## Authorization
- Authorization is done by fetching scopes from Cosmos DB

### Sample Entity in Cosmos

```
{
    "id": "<client_id>",
    "clientId": "<client_id>",
    "scopes": [
        "read",
        "read-write"
    ],
    "partitionKey": "client_id"
}
```

## SecurityConfig
Security configuration for endpoints
- Public endpoint can be accessed without token
- Read endpoint can be accessed with token and read scope
- Read-Write endpoint can be accessed with token and read-write scope

## ScopeChecker
This checks for whether a particular client has scope needed for endpoint

## ScopeService
This service fetches ScopeEntity from Redis Cache, if cache is empty/expired the scope is fetched from CosmosDB and Stored in Redis Cache.
