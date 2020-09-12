public class CommandProcessor {

    public void processCommand(String command){

        try{
            System.out.println("?????");
        }catch(CommandProcessorException e){
            System.out.println("exception caught in processCommand");

        }
    }

    public void processCommandFile(String commandFile){
        try{
            //@TODO: Process a set of commands provided within the given commandFile.
        }catch (CommandProcessorException e){
            System.out.println("exception caught in processCommandFile");
        }
    }

}
