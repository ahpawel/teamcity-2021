# Temcity Trial 2021

## Quick start

```bash
docker-compose up
```

Teamcity runs on [port 8111](http://localhost:8111). In case of permission issues you can try to boot up again. Otherwise you can bootup in background.

```bash
docker-compose up -d
```

## LINKS

- [Teamcity Documentation](https://www.jetbrains.com/help/teamcity/teamcity-documentation.html)
- [Installation instructions](https://www.jetbrains.com/help/teamcity/installation.html)
- [Postgres recommendations](https://www.jetbrains.com/help/teamcity/how-to.html#Configure+Newly+Installed+PostgreSQL+Server)

## BLOB

- Teamcity docker image size: 1.73 GB
- Internal database which is not recommended [for production](https://www.jetbrains.com/help/teamcity/setting-up-an-external-database.html#Default+Internal+Database)
