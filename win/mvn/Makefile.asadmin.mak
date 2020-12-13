all:

start:
	@asadmin start-domain $(GASADMIN_DOMAIN)
stop:
	@asadmin stop-domain $(GASADMIN_DOMAIN)
