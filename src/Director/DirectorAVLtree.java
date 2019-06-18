package Director;

import Movie.MovieNode;

public class DirectorAVLtree {

	
	
	DirectorNode tree;
	
	
	public boolean isEmpty(){
		
		return tree==null;
	}
	
	public void Director(DirectorNode d,MovieNode a){
		
		
		tree=insertDirector(tree,d.getName(),d.fbLikes,a);
	}
	
	public DirectorNode insertDirector(DirectorNode tree , String name,String fbLikes,MovieNode a){
		
		DirectorNode newnode = new DirectorNode(name, fbLikes);
        
		//		newnode.tree.name=name;
//		newnode.tree.fbLikes=fbLikes;
		if(tree==null){
			
			tree=newnode;
			newnode.insertMovies(a);
		}
		
		else{
			if(newnode.getName().compareTo(tree.getName())==0){
				tree.insertMovies(a);
			}
			
		    else if(newnode.getName().compareTo(tree.getName())<0){
		
			tree.left=insertDirector(tree.left,newnode.getName(),newnode.fbLikes, a);
		}
		    else{
				tree.right=insertDirector(tree.right,newnode.getName(),newnode.fbLikes,a);
			}
		}
	
		
        int balance = height(tree.left)-height(tree.right);
        
        
        if (balance > 1 && newnode.getName().compareTo(tree.left.getName())<0)
            return rightRotate(tree);
 
        if (balance < -1 && newnode.getName().compareTo(tree.right.getName())>0)
            return leftRotate(tree);
 
         if (balance > 1 && newnode.getName().compareTo(tree.left.getName())>0) {
            tree.left = leftRotate(tree.left);
            return rightRotate(tree);
        }
 
        if (balance < -1 && newnode.getName().compareTo(tree.right.getName())<0) {
            tree.right = rightRotate(tree.right);
            return leftRotate(tree);
        }
        return tree;
  
	}

	public int height(DirectorNode root){
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
	
	  public DirectorNode rightRotate(DirectorNode x){
      	 DirectorNode y = x.left;
         
          x.left = y.right;
          y.right=x;
         
          return y;
          }
      
          public  DirectorNode leftRotate(DirectorNode x){
      	  DirectorNode y = x.right;
          
          x.right = y.left;
          y.left = x;
          
          return y;
          }
          
          int i=0;
          public void print(DirectorNode tree){
        	  if(tree==null){
        		  return ;
        	  }
        	System.out.println(tree.getName());
        	System.out.println(i++);
        	
        	
        	print(tree.left);
        	print(tree.right);
          }
          
         
		
		public boolean searchByName(DirectorNode directors,String t){
    		if(directors==null){
    			return false;
    		}
    		else{
    			DirectorNode loc=directors;
    			while(loc!=null&&!loc.getName().equalsIgnoreCase(t)){
    			
    				if(loc.getName().compareTo(t)>=0){
    					loc=loc.left;
    				}
    				else{
    					loc=loc.right;
    				}
    			}
    			if(loc==null){
    				return false;
    			}
    			else{
    			    System.out.println(loc.right.getName());
    				return true;
    			}
    		}
    	 }
		public String searchDirector(String t){
			String output="";
			if(isEmpty()){
				output+="No Director is present";
			}
			else{
				DirectorNode loc=tree;
				
				while(loc!=null&&!loc.getName().equalsIgnoreCase(t)){
				
					if(loc.getName().compareTo(t)>0){
						loc=loc.left;
					}
					else{
						loc=loc.right;
					}
				}
				if(loc==null){
					output+="Director not present";
				}
				else{
					output=loc.print();
				}
			}
			return output;
		}
		
		
  	

		
	
}
