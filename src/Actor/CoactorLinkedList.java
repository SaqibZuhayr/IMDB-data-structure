package Actor;



public class CoactorLinkedList {

	CoactorNode coactors;
	 int numberofcoactors;
	 int i=1;

	public CoactorLinkedList() {
		
		
	}

	public boolean isEmpty(){
		return coactors==null;
	}
	public CoactorNode getCoactors() {
		return coactors;
	}

	public void setCoactors(CoactorNode coactors) {
		this.coactors = coactors;
	}
	
	public void insertCoactors(ActorNode actor){
		 
		 CoactorNode newnode = new CoactorNode();
		 newnode.coactors=actor;
		  
		 CoactorNode loc=coactors;
		   if(isEmpty()){
			   coactors=newnode;
			   newnode.next= coactors.next;
			   numberofcoactors++;
		   }
		   else{
			  if(!searchCoactor(actor.name)){
			   while(loc.next!=null){
				   loc=loc.next;
			   }
			   newnode.next=null;
			   loc.next=newnode;
			   ;
			   numberofcoactors++;
		   }
			  
		   }
		   }
	
	 public boolean searchCoactor(String data){
		  CoactorNode loc=coactors;
		   while(loc!=null&&!loc.coactors.name.equalsIgnoreCase(data)){
			  loc=loc.next;
		   }
		   if(loc==null){
			   return false;
		   }
		   else{
			   return true;
		   }
      }
	 
	 public String printCoactors(){
		 String output="";
		 if(isEmpty()){
			 output="No coactors";
		 }
		 else{
			CoactorNode loc=coactors;
			while(loc!=null){
				
				output+=loc.coactors.name+"\n";
				
				loc=loc.next;
			}
		 }
		 return output;
	 }
}

