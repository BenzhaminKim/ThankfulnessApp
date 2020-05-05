import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Button from '@material-ui/core/Button';
import CreateIcon from '@material-ui/icons/Create';
import Typography from '@material-ui/core/Typography';

const useStyles = makeStyles(theme => ({
    button: {
      margin: theme.spacing(1),
    },
  }));

export default function WriteCard(){
    
  const classes = useStyles();

    return (
        
    <Button
    href="/u/write"
        variant="contained"
        color="primary"
        size="large"
        className={classes.button}
        startIcon={<CreateIcon />}
      > <Typography align="center" variant="button">Write</Typography></Button>
        
    );
}