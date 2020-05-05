import React from 'react';
import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';
import TextareaAutosize from '@material-ui/core/TextareaAutosize';

export default function WritePage(){
    return (
        <React.Fragment>
       
            <Form.Group controlId="formBasicEmail">
                <Form.Label>Title</Form.Label>
                <Form.Control type="email" placeholder="Enter Title" />
                <Form.Text className="text-muted">
                </Form.Text>
            </Form.Group>

            <Form.Group controlId="formBasicPassword">
                <Form.Label>Content</Form.Label>
                <TextareaAutosize aria-label="minimum height" className={"form-control"} rowsMin={10} />
            </Form.Group>
            <Button variant="primary" type="submit">
                Submit
            </Button>
       
        </React.Fragment>
    );
}