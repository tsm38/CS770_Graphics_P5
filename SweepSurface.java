import javax.media.opengl.GL;

/**
 * Created by nicolegager on 12/2/14.
 */
public class SweepSurface extends Object3D {

    float [][] points;
    float [][] sweepPoints;
    float [][] sweptPoints;
    float [][] scaleFactor;



    public SweepSurface( float[][] points ){

        this.points = points;
    }

    @Override
    void setLocation() {

    }

    @Override
    void setSize() {

    }

    @Override
    protected void drawPrimitives() {
        float c = 0.4f;
        JOGL.gl.glPushMatrix();

        JOGL.gl.glBegin(GL.GL_TRIANGLE_STRIP);

        for(int i = 0; i < sweepPoints.length - 1; i++) {
            c+=c;
            JOGL.gl.glColor3f(c,c,c);
            for (int j = 0; j < points.length; j++) {
                JOGL.gl.glPushMatrix();
                JOGL.gl.glTranslatef(sweepPoints[i][0], sweepPoints[i][1], sweepPoints[i][2]);
                JOGL.gl.glVertex3f(points[j][0], points[j][1],points[j][2]);
                JOGL.gl.glPopMatrix();

                JOGL.gl.glPushMatrix();
                JOGL.gl.glTranslatef(sweepPoints[i + 1][0], sweepPoints[i + 1][1], sweepPoints[i + 1][2]);
                JOGL.gl.glVertex3f(points[j][0], points[j][1], points[j][2]);
                JOGL.gl.glPopMatrix();
            }

            // Handles the bottom! Im having so much fun!!
            JOGL.gl.glPushMatrix();
            JOGL.gl.glTranslatef(sweepPoints[i][0], sweepPoints[i][1], sweepPoints[i][2]);
            JOGL.gl.glVertex3f(points[0][0], points[0][1],points[0][2]);
            JOGL.gl.glPopMatrix();

            JOGL.gl.glPushMatrix();
            JOGL.gl.glTranslatef(sweepPoints[i+1][0], sweepPoints[i+1][1], sweepPoints[i+1][2]);
            JOGL.gl.glVertex3f(points[0][0], points[0][1],points[0][2]);
            JOGL.gl.glPopMatrix();

        }

        JOGL.gl.glEnd();

        JOGL.gl.glPopMatrix();


    }


    public void setSweep(float[][] sweepPoints){

this.sweepPoints = sweepPoints;
    }



    public void setScaleFactors(float[][] scaleFactor){
        this.scaleFactor = scaleFactor;



    }
}
