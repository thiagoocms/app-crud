const url = "http://localhost:5000/api/clients"
const btnCriar = document.getElementById("btnCriar")
const test = document.getElementById("test")
const result = document.getElementById("result")




 btnCriar.addEventListener("click",()=>{

  
  //criarrcd
  axios.post(url,getDados())
    .then(response => {
      const data =  response.data
    
      test.textContent = JSON.stringify(data)
      
      console.log(data)
      window.location.href = 'index.html'
      

    })
    .catch(error => console.log(error))
 })

 const getDados = ()=>{
  const client ={
    name: document.querySelector("#name").value ,
    fone: document.querySelector("#fone").value ,
    email: document.querySelector("#email").value ,
    job: document.querySelector("#job").value,
    birth: document.querySelector("#birth").value
  } 
  return client
 }


