#! /bin/sh
while true
do
	git add --all
	git commit -m "autocommit"
	sleep 3600
done
