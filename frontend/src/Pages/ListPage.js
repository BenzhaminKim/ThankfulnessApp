import React from 'react';
import Paper from '@material-ui/core/Paper';
import Grid from '@material-ui/core/Grid';
import WriteCard from '../Component/WriteCard';
import Typography from '@material-ui/core/Typography';
import { makeStyles} from '@material-ui/core/styles';


const useStyles = makeStyles((theme) => ({
    container:{
      flexGrow:1
    },
    paper: {
      padding: theme.spacing(2),
      textAlign: 'left',
    },
   
  }));

export default function ListPage(){
  const classes = useStyles();

    return (
        <div>
        <Grid container spacing={3}  direction="column" alignItems="center" justify="center">
          <Grid item xs={12} sm={12} md={12} lg={12}>
              <WriteCard/>
         </Grid>
        </Grid>


        <Grid container spacing={3}  alignContent="center" alignItems="flex-start" item="true">

            <Grid item xs={12} sm={6} md={4} lg={3}>
            <Paper className={classes.paper}>        
                    <Typography paragraph>
            Lorem ipsum dolor sit amets, consectetur adipiscing elit, sed do eiusmod tempor incididunt
            adipiscing bibendum est ultricies integer quis. Cursus euismod quis viverra nibh cras.
            Metus vulputate eu scelerisque felis imperdiet proin fermentum leo. Mauris commodo quis
            imperdiet massa tincidunt. Cras tincidunt lobortis feugiat vivamus at augue. At augue eget
            arcu dictum varius duis at consectetur lorem. Velit sed ullamcorper morbi tincidunt. Lorem
            donec massa sapien faucibus et molestie ac.
            </Typography>
        </Paper>
            </Grid>
            <Grid item xs={12} sm={6} md={4} lg={3}>
            <Paper className={classes.paper} >xs</Paper>
            </Grid>

            <Grid item xs={12} sm={6} md={4} lg={3}>
                <Paper className={classes.paper} >       
                 <Typography paragraph>
                    Consequat mauris nunc congue nisi vitae suscipit. Fringilla est ullamcorper eget nulla
                    facilisi etiam dignissim diam. Pulvinar elementum integer enim neque volutpat ac
                    tincidunt. Ornare suspendisse sed nisi lacus sed viverra tellus. Purus sit amet volutpat
                    consequat mauris. Elementum eu facilisis sed odio morbi. Euismod lacinia at quis risus sed
                    vulputate odio. Morbi tincidunt ornare massa eget egestas purus viverra accumsan in. In
                    hendrerit gravida rutrum quisque non tellus orci ac. Pellentesque nec nam aliquam sem et
                    tortor. Habitant morbi tristique senectus et. Adipiscing elit duis tristique sollicitudin
                    nibh sit. Ornare aenean euismod elementum nisi quis eleifend. Commodo viverra maecenas
                    accumsan lacus vel facilisis. Nulla posuere sollicitudin aliquam ultrices sagittis orci a.
                </Typography>
              </Paper>
            </Grid>
            <Grid item xs={12} sm={6} md={4} lg={3}>
                <Paper className={classes.paper} >       
                 <Typography paragraph>
                    Consequat mauris nunc congue nisi vitae suscipit. Fringilla est ullamcorper eget nulla
                    facilisi etiam dignissim diam. Pulvinar elementum integer enim neque volutpat ac
                </Typography>
              </Paper>
            </Grid>
            <Grid item xs={12} sm={6} md={4} lg={3}>
                <Paper className={classes.paper} >       
                 <Typography paragraph>
                    Consequat mauris nunc congue nisi vitae suscipit. Fringilla est ullamcorper eget nulla
                    facilisi etiam dignissim diam. Pulvinar elementum integer enim neque volutpat ac
                </Typography>
              </Paper>
            </Grid>
            <Grid item xs={12} sm={6} md={4} lg={3}>
                <Paper className={classes.paper} >       
                 <Typography paragraph>
                    Consequat mauris nunc congue nisi vitae suscipit. Fringilla est ullamcorper eget nulla
                    facilisi etiam dignissim diam. Pulvinar elementum integer enim neque volutpat ac
                </Typography>
              </Paper>
            </Grid>
            <Grid item xs={12} sm={6} md={4} lg={3}>
                <Paper className={classes.paper} >       
                 <Typography paragraph>
                    Consequat mauris nunc congue nisi vitae suscipit. Fringilla est ullamcorper eget nulla
                    facilisi etiam dignissim diam. Pulvinar elementum integer enim neque volutpat ac
                </Typography>
              </Paper>
            </Grid>
         </Grid>
        </div>
    );
}