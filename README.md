# SEV - Secure E-Voting


### The project is structered as two seperate applications.

### The first application is the "cert-email-sender", this is the application that the voters use to obtain their x509 certificate so that they can vote.

### The second application is "sev" this is where the actual voting happens. In order to be able to access anything from this application you first need to obtain your certificate via the first one.

### The "cert-email-sender" takes the voter EMBG and it uses it to find the signed certificate and send it to the Client.

### The Client receives the certificate via email.
