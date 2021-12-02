package org.jhotdraw.draw;

import org.jhotdraw.samples.svg.figures.SVGEllipseFigure;
import org.junit.Assert;
import org.junit.Test;


public class AbstractFigureTest {

    @Test
    public void validateListenersWorks() {
        AbstractFigure figure = new SVGEllipseFigure(50, 50, 50, 100);
        figure.addFigureListener(new FakeTestListener());

        try {
            figure.fireFigureRemoved();
            Assert.fail();
        } catch (EventCaughtException e) {
            Assert.assertEquals(e.getMethod(), "figureRemoved");
        }

        try {
            figure.fireFigureChanged();
            Assert.fail();
        } catch (EventCaughtException e) {
            Assert.assertEquals(e.getMethod(), "figureChanged");
        }
    }

    /**
     * Fake listener class, used to validate listeners receive events.
     * Will throw a {@link EventCaughtException} for every events, which can be caught by the test.
     */
    private static class FakeTestListener implements FigureListener {

        @Override
        public void areaInvalidated(FigureEvent e) {
            throw new EventCaughtException("areaInvalidated");
        }

        @Override
        public void attributeChanged(FigureEvent e) {
            throw new EventCaughtException("attributeChanged");
        }

        @Override
        public void figureHandlesChanged(FigureEvent e) {
            throw new EventCaughtException("figureHandlesChanged");
        }

        @Override
        public void figureChanged(FigureEvent e) {
            throw new EventCaughtException("figureChanged");
        }

        @Override
        public void figureAdded(FigureEvent e) {
            throw new EventCaughtException("figureAdded");
        }

        @Override
        public void figureRemoved(FigureEvent e) {
            throw new EventCaughtException("figureRemoved");
        }

        @Override
        public void figureRequestRemove(FigureEvent e) {
            throw new EventCaughtException("figureRequestRemove");
        }
    }

    /**
     * This is a "fake" exception, used to validate the listener caught the events
     */
    private static class EventCaughtException extends RuntimeException {
        private final String method;

        private EventCaughtException(String method) {
            this.method = method;
        }

        public String getMethod() {
            return method;
        }
    }

}
