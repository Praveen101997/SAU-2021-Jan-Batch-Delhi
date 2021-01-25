package praveen;

public class PersonServiceImplProxy implements praveen.PersonServiceImpl {
  private String _endpoint = null;
  private praveen.PersonServiceImpl personServiceImpl = null;
  
  public PersonServiceImplProxy() {
    _initPersonServiceImplProxy();
  }
  
  public PersonServiceImplProxy(String endpoint) {
    _endpoint = endpoint;
    _initPersonServiceImplProxy();
  }
  
  private void _initPersonServiceImplProxy() {
    try {
      personServiceImpl = (new praveen.PersonServiceImplServiceLocator()).getPersonServiceImpl();
      if (personServiceImpl != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)personServiceImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)personServiceImpl)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (personServiceImpl != null)
      ((javax.xml.rpc.Stub)personServiceImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public praveen.PersonServiceImpl getPersonServiceImpl() {
    if (personServiceImpl == null)
      _initPersonServiceImplProxy();
    return personServiceImpl;
  }
  
  public boolean deletePerson(int id) throws java.rmi.RemoteException{
    if (personServiceImpl == null)
      _initPersonServiceImplProxy();
    return personServiceImpl.deletePerson(id);
  }
  
  public praveen.Person getPerson(int id) throws java.rmi.RemoteException{
    if (personServiceImpl == null)
      _initPersonServiceImplProxy();
    return personServiceImpl.getPerson(id);
  }
  
  public praveen.Person[] getAllPersons() throws java.rmi.RemoteException{
    if (personServiceImpl == null)
      _initPersonServiceImplProxy();
    return personServiceImpl.getAllPersons();
  }
  
  public boolean addPerson(praveen.Person p) throws java.rmi.RemoteException{
    if (personServiceImpl == null)
      _initPersonServiceImplProxy();
    return personServiceImpl.addPerson(p);
  }
  
  
}