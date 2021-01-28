import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { report } from 'process';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {


  constructor(private httpClient:HttpClient){}

  admID
  admPwd
  trans:any=[]
  addTransactionPanel=false
  ListTransactionPanel=false
  transactionMsg=''
  showAdminInput=false;
  adminPanelEnable:boolean=false;
  userPanelEnable:boolean=false;
  addUserRtnMsg:String=''
  userFuncEnable=false;
  addUserPanel:boolean=false;
  addedSuccess:boolean=false;
  uName
  accNo
  amount;
  serialNo

  getAllTrans()
  {
    this.httpClient.get('http://localhost:8080/trans/getTransByT/'+0).subscribe(data=>{
      this.trans=data
    })
  }

  getIlgTrans()
  {
    this.httpClient.get('http://localhost:8080/trans/getTransByT/'+2).subscribe(data=>{
      this.trans=data
    })
  }

  getLglTrans()
  {
    this.httpClient.get('http://localhost:8080/trans/getTransByT/'+1).subscribe(data=>{
      this.trans=data
    })
  }

  addTrans()
  {
    this.httpClient.post('http://localhost:8080/trans/addTrans',{transaction:{accountNumber:this.accNo,currencySerial:this.serialNo},amount:this.amount}).subscribe(reponse=>{
      this.transactionMsg = "Your transaction Id is " + reponse;
    })
  }

  viewTrans()
  {
    this.httpClient.get('http://localhost:8080/trans/getTransByN/'+this.accNo).subscribe(data =>{
      this.trans=data;
    })
  }

  addUser()
  {

    this.httpClient.post('http://localhost:8080/user/addUser',{userName:this.uName,accountNumber:this.accNo},{responseType: 'text'}).subscribe(response=>{
      this.addUserRtnMsg=response;
    })

  }

  authAdmin()
  {
    this.httpClient.post('http://localhost:8080/user/auth',{id:this.admID,password:this.admPwd}).subscribe(response=>{
      if(response==null)
      {
        alert("Invalid Credentials, Please Check User Id or Password");
        this.authAdmin_();
        this.adminPanelEnable=false;
      }
      else
      {
        this.adminPanelEnable=true;
      }
      console.log(response)
    })
  }

  loginUser()
  {
    this.httpClient.get('http://localhost:8080/user/getByAC/'+this.accNo).subscribe(data=>{
      if(data==null)
      {
        alert("User details not Found");
        this.userFuncEnable=false;

      }
      else
      {
        this.uName=data['userName'];
        this.userFuncEnable=true;
      }
    })
  }

  authAdmin_()
  {
    this.showAdminInput=true;
    this.userPanelEnable=false;
    this.userFuncEnable=false;
    this.addUserPanel=false;
    this.trans=[]
  }

  authUser_()
  {
    this.showAdminInput=false;
    this.trans=[]
    this.userPanelEnable=true;
    this.adminPanelEnable=false;
    this.addUserPanel=false;
    this.userFuncEnable=false;

  }

  viewUserPanel_()
  {
    this.showAdminInput=false;
    this.userPanelEnable=false;
    this.adminPanelEnable=false;
    this.addUserPanel=true;
    this.userFuncEnable=false;
  }
}
