<script>
trigger();
setInterval(checkTimeOut, 2000);

function trigger(){
window.addEventListener("mousemove", updateTimeout);
}

function updateTimeout(){
localStorage.setItem("expiry", Date.now() + 1000000);
}

function checkTimeOut() {
const time =parseInt( localStorage.getItem("expiry") || 0,10);
  console.log(time+">"+Date.now());
  if(time< Date.now()){
  	console.log("timeout");
  }
}
</script>
