package Actor;

import Movie.MovieNode;

public class ActorAVLTree {

	ActorNode actors;
	
	public boolean isEmpty(){
	
		return actors==null;
	}
	
    public void Actors(ActorNode a,ActorNode coactor1,ActorNode coactor2,MovieNode m){
		
		
		actors=insertActors(actors,a,coactor1,coactor2,m);
	}
    
	private ActorNode insertActors(ActorNode actors,ActorNode data,ActorNode coactor1,ActorNode coactor2,MovieNode movie){
		
		try {
			if(actors==null){
				
				actors=data;
				data.insertmovies(movie);
				data.coactorslist.insertCoactors(coactor1);
				data.coactorslist.insertCoactors(coactor2);
			}
			
			else{
				if(data.name.compareTo(actors.name)==0){
					actors.insertmovies(movie);
					actors.coactorslist.insertCoactors(coactor1);
					actors.coactorslist.insertCoactors(coactor2);
				}
				
			    else if(data.name.compareTo(actors.name)<0){
			
				actors.left=insertActors(actors.left,data, coactor1, coactor2, movie);
			}
			    else{
			    actors.right=insertActors(actors.right,data,coactor1, coactor2, movie);
				}
			}


			
			int balance = height(actors.left)-height(actors.right);
			
			
			if (balance > 1 && data.name.compareTo(actors.name)<0)
			    return rightRotate(actors);
 
			if (balance < -1 && data.name.compareTo(actors.name)>0)
			    return leftRotate(actors);
 
			 if (balance > 1 && data.name.compareTo(actors.name)>0) {
			    actors.left = leftRotate(actors.left);
			    return rightRotate(actors);
			}
 
			if (balance < -1 && data.name.compareTo(actors.name)<0) {
			    actors.right = rightRotate(actors.right);
			    return leftRotate(actors);
			}
			return actors;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return actors;
		}
		
			  
	}
	
	       
	public int height(ActorNode root){
		if(root==null){
			return 0;
		}
		int left=height(root.left);
		int right=height(root.right);
		if(left>right){
			return left+1;
		}
		else{
			return right+1;
		}
		
	}
	
	  public ActorNode rightRotate(ActorNode x){
      	 ActorNode y = x.left;
         
          x.left = y.right;
          y.right=x;
         
          return y;
          }
      
          public  ActorNode leftRotate(ActorNode x){
      	  ActorNode y = x.right;
          
          x.right = y.left;
          y.left = x;
          
          return y;
          }
          
          int i=0;
          public void print(ActorNode tree){
        	  if(tree==null){
        		  return ;
        	  }
        	System.out.println(tree.name);
        	System.out.println(i++);
        	
        	
        	print(tree.left);
        	print(tree.right);
          }
          
          public boolean searchByName(ActorNode actors,String t){
      		if(actors==null){
      			return false;
      		}
      		else if (actors.name.equalsIgnoreCase(t)){
      			return true;
      		}
      		else{
      			if(actors.name.compareTo(t)<0){
      				return searchByName(actors.left,t);
      			}
      			else {
      				return searchByName(actors.right,t);
      			}
      		}
      		
      	 }
          public String searchActor(String t){
        	 String output="";
  			if(isEmpty()){
  				output="No Actor is present";
  			}
  			else{
  				ActorNode loc=actors;
  				while(loc!=null&&!loc.name.equalsIgnoreCase(t)){
  					if(loc.name.compareTo(t)>0){
  						loc=loc.left;
  					}
  					else{
  						loc=loc.right;
  					}
  				}
  				if(loc==null){
  					output="Actor not present";
  				}
  				else{
  					output="Name : "+loc.name+"\nFbLikes : "+loc.fblikes+"\n \nMovies Of "+loc.name+" :\n"+loc.movies.print();
  				}
  			}
  			return output;
  		}
          String output="";
         public String printCoactors(ActorNode node,String t){
        	 
        	 if(node==null){
        		 return "";
        	 }
        	 else{
        		 if(node.name.equalsIgnoreCase(t)){
        			 output+="Name : "+t+"\n";
        			 output+="Co-Actors : \n\n";
        			 output+=node.coactorslist.printCoactors();
        		 }
        		 printCoactors(node.left,t);
        		 printCoactors(node.right,t);
        	 }
        	 return output;
         }
         public String searchCoactorsInMovie(String actor,String movie){
        	String output="";
 			if(isEmpty()){
 				output="No Actor is present";
 			}
 			else{
 				ActorNode loc=actors;
 				while(loc!=null&&!loc.name.equalsIgnoreCase(actor)){
 					if(loc.name.compareTo(actor)>0){
 						loc=loc.left;
 					}
 					else{
 						loc=loc.right;
 					}
 				}
 				if(loc==null){
 					output="Actor is not present";
 				}
 				else{
 					output=loc.printCoactorsInMovie(loc.name, movie);
 				}
 			}
 			return output;
 		}
         
  	

    
}
