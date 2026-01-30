Agoda

Find “why website is slow only for a particular customer"?

Integrate the web-vitals library in your app.

import {getLCP, getCLS, getINP} from 'web-vitals';
getLCP(console.log); // Largest contentful paint -> How fast content appears
getCLS(console.log); // Cumulative Layout Shift -> Visual stability
getINP(console.log); // Interaction to Next Paint -> fast does the page respond when I interact

Send LCP, CLS, INP values to your backend (e.g. via an API).

Also log:
navigator.hardwareConcurrency (CPU cores)
navigator.deviceMemory (RAM hint in GB)
navigator.connection.effectiveType (network: 4g/3g/2g)

Browser version & OS

Does he have 2 CPU cores + 1GB RAM + 3g network? That’s your answer.
