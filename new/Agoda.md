Agoda

Find “why website is slow only for a particular customer"?

Integrate the web-vitals library in your app.

import {getLCP, getCLS, getINP} from 'web-vitals';
getLCP(console.log);
getCLS(console.log);
getINP(console.log);

Send LCP, CLS, INP values to your backend (e.g. via an API).

Also log:
navigator.hardwareConcurrency (CPU cores)
navigator.deviceMemory (RAM hint in GB)
navigator.connection.effectiveType (network: 4g/3g/2g)

Browser version & OS

Does he have 2 CPU cores + 1GB RAM + 3g network? That’s your answer.


React fiber