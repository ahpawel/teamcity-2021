# Temcity Trial 2021

## Quick start

```bash
docker-compose up
```

Teamcity runs on [port 8111](http://localhost:8111). In case of permission issues you can try to boot up again. Otherwise you can bootup in background.

```bash
docker-compose up -d
```

To activate an agent go to Agents > [Unauthorized](http://localhost:8111/agents.html?tab=unauthorizedAgents) and click Authorize near the agent.

Set `teamcity.docker.use.sudo=true` in `buildAgent.properties` file if needed and restart worker.

## Preperation before the first build

1. Login to docker https://www.jetbrains.com/help/teamcity/docker-support.html

## Clean-up

- Remove configuration files: `rm -rf agents teamcity postgres`
- Remove docker containers: `docker-compose down`

## LINKS

- [Teamcity Documentation](https://www.jetbrains.com/help/teamcity/teamcity-documentation.html)
- [Installation instructions](https://www.jetbrains.com/help/teamcity/installation.html)
- [Postgres recommendations](https://www.jetbrains.com/help/teamcity/how-to.html#Configure+Newly+Installed+PostgreSQL+Server)

## BLOB

- Teamcity docker image size: 1.73 GB
- Internal database which is not recommended [for production](https://www.jetbrains.com/help/teamcity/setting-up-an-external-database.html#Default+Internal+Database)
- Runing docker in docker is not recommended http://jpetazzo.github.io/2015/09/03/do-not-use-docker-in-docker-for-ci/
- Teamcity Setup by CodeMaze https://code-maze.com/preparing-ci-environment-docker/