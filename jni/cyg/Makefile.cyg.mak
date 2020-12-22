all:

cyg:
	wget $(GCYG_PAT_GET)
	chmod +x apt-cyg
	mv apt-cyg /usr/local/bin
ins:
	apt-cyg install $(GCYG_PACKAGE) 
