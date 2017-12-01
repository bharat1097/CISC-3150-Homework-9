public class FourThreadProg {

    int status = 1;
    public static void main(String[] args) throws Throwable {

        FourThreadProg m_t_p = new FourThreadProg();

        Thread1 thread_1 = new Thread1(m_t_p);
        Thread2 thread_2 = new Thread2(m_t_p);
        Thread3 thread_3 = new Thread3(m_t_p);
        Thread4 thread_4 = new Thread4(m_t_p);
        
        thread_1.start();
        thread_2.start();
        thread_3.start();
        thread_4.start();
    }
}

class Thread1 extends Thread {
    FourThreadProg m_t_p;
    char[] arr1 = {'A','E','I','M' ,'Q', 'U', 'Y'};

    Thread1(FourThreadProg m_t_p){
        this.m_t_p = m_t_p;
    }

    public void run(){
    	try{
            synchronized(m_t_p){
            	for(char c:arr1){ 
            		
            		while(m_t_p.status != 1)
            			m_t_p.wait();
            	
	            	System.out.print(c + " ");
	            	m_t_p.status = 2;
	            	m_t_p.notifyAll();
            	}
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

class Thread2 extends Thread {

    FourThreadProg m_t_p;
    char[] arr2 = {'B', 'F', 'J' ,'N' ,'R' ,'V' ,'Z'};

    Thread2(FourThreadProg m_t_p){
        this.m_t_p = m_t_p;
    }

    public void run(){
    	try{
    		synchronized(m_t_p){
    			for(char c:arr2){
    				
    				while(m_t_p.status != 2)
                        m_t_p.wait();
                    
                    System.out.print(c + " ");
                    m_t_p.status = 3;
                    m_t_p.notifyAll();
                }
    		}
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}

class Thread3 extends Thread{

    FourThreadProg m_t_p;
    char[] arr3 = {'C', 'G', 'K' ,'O' ,'S' ,'W'};

    Thread3(FourThreadProg m_t_p){
        this.m_t_p = m_t_p;
    }

    public void run(){
    	try{
            synchronized(m_t_p){

                for(char c:arr3){
                	
                	while(m_t_p.status != 3)
                        m_t_p.wait();

                	System.out.print(c + " ");
                    m_t_p.status = 4;
                    m_t_p.notifyAll();
                }
            }
        }catch (Exception e){
        	e.printStackTrace();
        }
    }
}

class Thread4 extends Thread{

    FourThreadProg m_t_p;
    char[] arr4 = {'D', 'H', 'L' ,'P' ,'T' ,'X'};

    Thread4(FourThreadProg m_t_p){
        this.m_t_p = m_t_p;
    }

    public void run(){
    	try{
            synchronized (m_t_p){

                for(char c:arr4){

                    while(m_t_p.status != 4)
                        m_t_p.wait();

                    System.out.print(c + " ");
                    m_t_p.status = 1;
                    m_t_p.notifyAll();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}