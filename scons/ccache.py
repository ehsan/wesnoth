# vi: syntax=python:et:ts=4
# Shamelessly stolen from FreeOrion's SConstruct
# http://freeorion.svn.sourceforge.net/viewvc/freeorion/trunk/FreeOrion/SConstruct?revision=2478&view=markup

import os

def exists():
    return True

def generate(env):
        env['CC'] = 'ccache %s' % env['CC']
        env['CXX'] = 'ccache %s' % env['CXX']
        for i in ['HOME',
                  'CCACHE_DIR',
                  'CCACHE_TEMPDIR',
                  'CCACHE_LOGFILE',
                  'CCACHE_PATH',
                  'CCACHE_CC',
                  'CCACHE_PREFIX',
                  'CCACHE_DISABLE',
                  'CCACHE_READONLY',
                  'CCACHE_CPP2',
                  'CCACHE_NOSTATS',
                  'CCACHE_NLEVELS',
                  'CCACHE_HARDLINK',
                  'CCACHE_RECACHE',
                  'CCACHE_UMASK',
                  'CCACHE_HASHDIR',
                  'CCACHE_UNIFY',
                  'CCACHE_EXTENSION']:
            if os.environ.has_key(i) and not env.has_key(i):
                env['ENV'][i] = os.environ[i]
