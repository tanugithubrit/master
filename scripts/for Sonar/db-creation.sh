#!/bin/bash
set -e

	
psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" <<-EOSQL
	createuser sonar;
	ALTER USER sonar WITH ENCRYPTED password 'Verinite@123';
	CREATE DATABASE sonarqube OWNER sonar;
	GRANT ALL PRIVILEGES ON DATABASE sonarqube to sonar;
EOSQL

