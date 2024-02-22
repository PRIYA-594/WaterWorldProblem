import java.util.*;
class Cluster
{
    String name;
    int d;
    int storage;
    int cuSt;
    String febo;
    Cluster(String name,int d,int storage)
    {
        this.name=name;
        this.d=d;
        this.storage=storage;
        this.cuSt=0;
    }
    void setName(String name)
    {
        this.name=name;
    }
    void setCur(int st)
    {
        this.cuSt=st;
    }
    int getSto()
    {
        return storage;
    }
    int getCur()
    {
        return cuSt;
    }
    int getNes()
    {
        return d;
    }
    String getName()
    {
        return name;
    }
    int getStorage()
    {
        return storage;
    }
    void setFebo(String str)
    {
        this.febo=str;
    }
    String getFebo()
    {
        return febo;
    }
}
public class Water
{
    public static void main(String args[])
    {
        Scanner s =new Scanner(System.in);
        int day = s.nextInt();
        int c = s.nextInt();
        ArrayList<Cluster> cul = new ArrayList<>();
        for(int i=0;i<c;i++)
        {
            cul.add(new Cluster(s.next(),s.nextInt(),s.nextInt()));
        }
        int l = s.nextInt();
        for(int i=0;i<l;i++)
        {
            String str = s.next();
            String[] sp = str.split("_");
            for(Cluster cl: cul)
            {
                if(sp[1].equals(cl.getName()))
                {
                    cl.setFebo(sp[0]);
                }
            }
        }
        int capacity=0;
        while(day!=0)
        {
            for(Cluster cl:cul)
            {
                if(cl.getCur()<cl.getNes())
                {
                    if(cl.getFebo().equals("F"))
                    {
                        int need = cl.getStorage()-cl.getCur();
                        cl.setCur(need);
                        capacity+=need;
                    }
                    else
                    {
                        for(Cluster cs:cul)
                        {
                            if(cl.getFebo().equals(cs.getName()))
                            {
                                if(cs.getCur()<cl.getNes())
                                {
                                    int need = cs.getStorage()-cs.getCur();
                                    cs.setCur(need);
                                    capacity+=need;
                                    break;
                                }
                            }
                        }
                        int neneed = cl.getStorage()-cl.getCur();
                        cl.setCur(neneed);
                        capacity+=neneed;
                    }
                    cl.setCur(cl.getCur()-cl.getNes());
                }
                else
                {
                    cl.setCur(cl.getCur()-cl.getNes());
                }
            }
            day--;
        }
        System.out.println(capacity);
        
    }
}
